import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RouterModule , Router } from '@angular/router';
import { Config } from '../env/index';

@Injectable()
export class BackendService {
  
  constructor(private httpClient: HttpClient, private router : Router) {}

  viewTasks(inputParam) {
     const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.httpClient.post(Config.API+'task/viewTasks',
      inputParam,
      {headers: headers});
  }

   updateTask(inputParam) {
      const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.httpClient.post(Config.API+'task/updateTask',
      inputParam,
      {headers: headers});
  }

}
