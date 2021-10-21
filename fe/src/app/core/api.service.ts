import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private readonly urlPrefix = 'http://127.0.0.1:8080';

  constructor(private http: HttpClient) {
  }

  get(url: string) {
    return this.http.get(this.urlPrefix + url);
  }

  post(url: string, data: object) {
    const headers = {
      'Content-Type': 'application/json'
    };
    const requestOptions = {
      headers
    };
    return this.http.post(this.urlPrefix + url, data, requestOptions);
  }

  delete(url: string) {
    return this.http.delete(`${this.urlPrefix}${url}`);
  }
}
