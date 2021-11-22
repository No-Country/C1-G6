import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  public numberTable:string = "Mesa X"

  constructor(
    private _router: Router
  ) { }

  ngOnInit(): void {
  }

  addFood(){
    this._router.navigate(['Card']);
  }
}
