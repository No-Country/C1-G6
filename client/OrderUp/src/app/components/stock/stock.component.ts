import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  constructor() { }
  public products = [
    {
      name: "milanesa",
      stock: true
    },
    {
      name: "milanesa completa",
      stock: true
    },
    {
      name: "hamburguesa",
      stock: true
    },
    {
      name: "coca-cola",
      stock: true
    },
    {
      name: "agua",
      stock: true
    },
    {
      name: "papas fritas",
      stock: true
    },
    {
      name: "chocolina",
      stock: true
    }
  ];
  
  ngOnInit(): void {
  }

}
