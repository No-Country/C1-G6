import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/produtc.service';

@Component({
  selector: 'stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css'],
  providers: [ProductService]
})
export class StockComponent implements OnInit {
  public products: Product[] = [];

  constructor(
    private _ProductService: ProductService
  ) { }
  
  ngOnInit(): void {
    this._ProductService.getProducts().subscribe(
      response => {
        this.products = response;
      },
      err => {
        console.log("-----------------------");
        console.log(err);
        console.log("-----------------------");
      }
    )
  }

}
