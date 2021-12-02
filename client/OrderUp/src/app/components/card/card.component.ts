import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute,Params } from '@angular/router';
import { ProductService } from 'src/app/services/produtc.service';
import * as $ from 'jquery';
import { Product } from 'src/app/models/Product';
import { Category } from 'src/app/models/Category';
import { Order } from 'src/app/models/Order';
import { Global } from 'src/app/services/global';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  providers: [ProductService]
})
export class CardComponent implements OnInit {
  public order: Order = {comments:"",id:0,table:{id:0,tableNumber:-1, id_order: -1},productlist:"",user:{id:0,name:"",surname:"",password:"",email:"",phone:0,role_id:{id:0,name:""}}}
  public Categorys: Category[] = []
  public Products: Product[] = []
  public ProductsOrder: Product[] = []
  constructor(
    private _router: Router,
    private _ProductService: ProductService,
    private _route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getProducts();
    this.getCategorys();
    this._route.params.subscribe(params => {
      let id = params.id;
      this.getOrder(id);
    });
  }

  reviewOrder(){
    this._route.params.subscribe(params => {
      let id = params.id;
     this._router.navigate(['Order',id]);
    });
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

  getOrder(id:number) {
    this._ProductService.getOrder(id).subscribe(
      response => {
        this.order = response;
        if(this.order.productlist == ""){
          sessionStorage.setItem('order',"");
        }else {
          sessionStorage.setItem('order',this.order.productlist);
        }
      },
      err => {
        console.log(err);
      }
    )
  }

  addProdouct(id_product:any){
    var aux = sessionStorage.getItem('order');
    if (aux){
      aux += "/"+id_product;
      sessionStorage.setItem('order',aux);
    }
  }

  RemoveProduct(id_product:number){
    var aux = sessionStorage.getItem('order');
    if (aux){
      var array = aux.split('/');
      aux = "";
      for (let i = 0; i < array.length; i++) {
        if(parseInt(array[i]) == id_product){
          array.splice(i,1);
        }
      }
      for (let i = 0; i < array.length; i++) {
        aux += array[i]+'/'
      }
      sessionStorage.setItem('order',aux);
    }
  }

  

  updateProduct(order: Order){
    var formData = new FormData();
      var table_id = order.table.id.toString()
      var user_id = order.user.id.toString()
      var productlist = sessionStorage.getItem('order')
      if (productlist) {
        formData.append("productlist", productlist);
      }else {
        formData.append("productlist", order.productlist);
      }
      formData.append("table_id", table_id);
      formData.append("comments", order.comments);
      formData.append("user_id", user_id);   
      
      var request = new XMLHttpRequest();
      request.open("PUT", Global.url+"/orders/"+order.id);
      request.send(formData);
  }

  
}
