
package controllers

import java.io.{File, IOException, PrintWriter}
import java.util.Properties

import com.sksamuel.avro4s.AvroOutputStream
import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.http.ElasticDsl._
import com.sksamuel.elastic4s.http.HttpClient
import com.sksamuel.elastic4s.http.search.{SearchHit, SearchIterator}
import edu.stanford.nlp.ling.CoreAnnotations.{SentencesAnnotation, _}
import edu.stanford.nlp.ling.CoreLabel
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import edu.stanford.nlp.util.CoreMap
import org.apache.avro.file.DataFileReader
import org.apache.avro.specific.SpecificDatumReader

import scala.collection.JavaConverters._
import scala.collection.immutable.ListMap
import scala.collection.mutable
import scala.concurrent.duration._

import controllers.analogyHelpers.readAvro
import controllers.analogyExtr


object analogyExtrMain {


  def main(args: Array[String]): Unit = {
    // - - - - - - - - - - - - - - - - - - - - - - - - -
    // get coOccurrences from avro file (takes a while)
    // - - - - - - - - - - - - - - - - - - - - - - - - -

    println("READ AVRO")
    val coOccurrences: Map[String, Map[String, Int]] = readAvro()
    println("READY READ AVRO")

    // - - - - - - - - - - - - - - - - - - - - - - - - -
    // load the stanford annotator for NER tagging and lemmatisation
    // - - - - - - - - - - - - - - - - - - - - - - - - -

    println("LOADING STANFORD PARSER NER")
    val props: Properties = new Properties() // set properties for annotator
    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, regexner")
    props.put("regexner.mapping", "data/jg-regexner.txt")
    val pipelineNER: StanfordCoreNLP = new StanfordCoreNLP(props) // annotate file
    println("READY LOADING STANFORD PARSER NER")

    // - - - - - - - - - - - - - - - - - - - - - - - - -
    // load the stanford annotator for ssplit
    // - - - - - - - - - - - - - - - - - - - - - - - - -

    println("LOADING STANFORD PARSER Split")
    val propsSplit: Properties = new Properties()
    propsSplit.put("annotators", "tokenize, ssplit")
    val pipelineSplit: StanfordCoreNLP = new StanfordCoreNLP(propsSplit)
    println("READY LOADING STANFORD PARSER Split")

    var doc1:String = "Car crash in New York"


    val newAnaloyExtraction = new analogyExtr(coOccurrences,pipelineNER,pipelineSplit,Map[String, Int](),0)
    var vectorDoc1: Map[String, Int] = newAnaloyExtraction.accumulatedDocumentVector(doc1)._1
    var lengthFirstWordVector: Double = newAnaloyExtraction.lengthOfVector(vectorDoc1)
    newAnaloyExtraction.vectorDoc1 = newAnaloyExtraction.accumulatedDocumentVector(doc1)._1
    newAnaloyExtraction.lengthFirstWordVector = newAnaloyExtraction.lengthOfVector(vectorDoc1)
    newAnaloyExtraction.calcDistanceAPI("Car crash in New York")


    //implicit val timeout: FiniteDuration = Duration(1000, "seconds") // is the timeout for the SearchIterator.hits method
    //implicit val client: HttpClient = HttpClient(ElasticsearchClientUri("localhost", 9200)) // new client
    //allCoOccurrences(atleastCooccurence = 50) // numberOfResults = 0 means unlimited
    //allDistances
    //"Accident in Manhattan"
    //calcDistanceOfDocs("Car crash in New York")
    //calcDistanceOfDocsWithinElastic("Car crash in New York", false)
    //allNerTyps()
    //allTokens()
    //client.close() // close HttpClient
  }
}

