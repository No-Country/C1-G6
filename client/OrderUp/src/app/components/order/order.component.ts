import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/models/Order';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/produtc.service';
@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
  providers: [ProductService]
})
export class OrderComponent implements OnInit {
  public numberTable:string = "Mesa X"
  public order: Order = {comments:"",id:0,table:{id:0,tableNumber:-1,id_order: -1},productlist:"",user:{id:0,name:"",surname:"",password:"",email:"",phone:0,role_id:{id:0,name:""}}}
  public products: Product[] = [];
  public total: number = 0;
  constructor(
    private _router: Router,
    private _ProductService: ProductService,
    public _route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this._route.params.subscribe(params => {
      let id = params.id;
      this.getOrder(id);
  });
  }

  addFood(){
    this._route.params.subscribe(params => {
      let id = params.id;
      this._router.navigate(['Card',id]);
    });
  }

  goTables(){
    this._router.navigate(['Tables']);
  }

  getOrder(id:any){
    this._ProductService.getOrder(id).subscribe(
      response => {
        this.order = response;
        this.getProducts();
      },
      err => {
        console.log(err);
      }
    )
  }

  getProducts(){
    var aux = this.order.productlist.split('/');
    for (let i = 0; i < aux.length; i++) {
      this._ProductService.getProduct(parseInt(aux[i])).subscribe(
        response => {
          this.products.push(response);
          this.total += parseInt(response.price);
        },
        err => {
          console.log(err);
        }
      )      
    }
  }
}
