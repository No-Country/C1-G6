import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute,Params } from '@angular/router';
import { ProductService } from 'src/app/services/produtc.service';
import * as $ from 'jquery';
import { Product } from 'src/app/models/Product';
import { Category } from 'src/app/models/Category';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  providers: [ProductService]
})
export class CardComponent implements OnInit {
 
  public Categorys: Category[] = []
  public Products: Product[] = []
  constructor(
    private _router: Router,
    private _ProductService: ProductService,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getProducts();
    this.getCategorys();
  }

  reviewOrder(){
    this._router.navigate(['Order']);
  }
  blur(index:number){
    var clas = '.category'+index;
    var aux = $(clas);
    var class_list = aux.attr('class');

    if(class_list){
      if(class_list.split(' ').includes('blur')){
        aux.removeClass('blur');
      }else {
        aux.addClass('blur');
      }
    }
  }

  getProducts() {
    this._ProductService.getProducts().subscribe(
      response => {
        this.Products = response;
        console.log(this.Products)
      },
      err => {
        console.log("-----------------------")
        console.log(err);
        console.log("-----------------------")
      }
    )
  }

  getCategorys() {
    this._ProductService.getCategorys().subscribe(
      response => {
        this.Categorys = response;
      },
      err => {
        console.log("-----------------------")
        console.log(err);
        console.log("-----------------------")
      }
    )
  }
}
