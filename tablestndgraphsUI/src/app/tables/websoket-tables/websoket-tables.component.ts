import { Component, OnInit } from '@angular/core';

import {MatTableDataSource} from '@angular/material';
import {RestDataSource} from "../../service/rest.datasource";
import {Observable, timer} from "rxjs";
import {UserFullInformationModel} from "../../model/UserFullInformation.model";
import {RateToHryvnia} from "../../model/RateToHryvnia";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-websoket-tables',
  templateUrl: './websoket-tables.component.html',
  styleUrls: ['./websoket-tables.component.css']
})
export class WebsoketTablesComponent implements OnInit {
  users: Observable<RateToHryvnia[]>;
  constructor(private restDataSourse: RestDataSource) { }

  ngOnInit() {

    timer(0, 3000).pipe(
      map(() => {this.users = this.restDataSourse.getRateToHryvnia();})
    ).subscribe();
  }



}


