import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/Order';
import { Product } from 'src/app/models/Product';
import { Table } from 'src/app/models/Table';
import { Global } from 'src/app/services/global';
import { ProductService } from 'src/app/services/produtc.service';

@Component({
  selector: 'tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css'],
  providers: [ProductService]
})
export class TablesComponent implements OnInit {
  public orders: Order[] = [];
  public tables: Table[] = [
    {id: 1,tableNumber: 1, id_order: -1},
    {id: 2,tableNumber: 2, id_order: -1},
    {id: 3,tableNumber: 3, id_order: -1},
    {id: 4,tableNumber: 4, id_order: -1}
  ];
  constructor(
    private _ProductService : ProductService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    sessionStorage.setItem('order',"");
    this.getOrders();
  }

  getOrders() {
    this._ProductService.getOrders().subscribe(
      response => {
        this.orders = response;
        for (let i = 0; i < this.tables.length; i++) {
          for (let e = 0; e < this.orders.length; e++) {
            if(this.tables[i].tableNumber == this.orders[e].table.tableNumber){
              this.tables[i].id_order = this.orders[e].id;
              break
            }
          }
        }
      },
      err => {
        console.log("-----------------------");
        console.log(err);
        console.log("-----------------------");
      }
    )
  }

  goOrder(id_order:number, table_id:number) {
    if(id_order == -1){
      var formData = new FormData();

      var table = table_id.toString();

      formData.append("productlist", "");
      formData.append("table", table);
      formData.append("comments", "");
      formData.append("user", '2');
      
      var request = new XMLHttpRequest();
      request.open("POST", Global.url+"/orders");
      request.send(formData);

    }
    else {
      this._router.navigate(['/Order',id_order]);
    }
  }


}
