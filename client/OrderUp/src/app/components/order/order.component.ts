import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/produtc.service';
@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
  providers: [ProductService]
})
export class OrderComponent implements OnInit {
  public numberTable:string = "Mesa X"

  constructor(
    private _router: Router,
    private _ProductService: ProductService
  ) { }

  ngOnInit(): void {
  }

  addFood(){
    this._router.navigate(['Card']);
  }


}
