
export class Sentence {
    _sentences: string;
    _sentence: Array<any>;
    _id: string;
    _similarity: number;
    constructor(_sentences: string, _sentence: Array<any>, _id:string,_similarity:number) {
      this._sentences = _sentences;
      this._sentence = _sentence;
      this._id = _id;
      this._similarity = _similarity;
  }
  }
  