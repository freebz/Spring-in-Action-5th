// Listing 6.1  Angular component for displaying recent tacos

import { Component, OnInit, Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'recent-tacos',
    templateUrl: 'recents.component.html',
    styleUrls: ['./recents.component.css']
})

@Injectable()
export class RecentTacosComponent implements OnInit {
    recentTacos: any;

    constructor(private httpClient: HttpClient) { }

    ngOnInit() {
	this.httpClient.get('http://localhost:8080/design/recento')
	    .subscribe(data => this.recentTacos = data);
    }
}
