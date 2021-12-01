import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { routing, appRoutingProviders } from './app.routing';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { StockComponent } from './components/stock/stock.component';
import { LoginComponent } from './components/login/login.component';
import { CardComponent } from './components/card/card.component';
import { TableComponent } from './components/table/table.component';
import { TablesComponent } from './components/tables/tables.component';
import { OrderComponent } from './components/order/order.component';
import { RegisterComponent } from './components/register/register.component';
import { AdministradorComponent } from './components/administrador/administrador.component';
import { PersonalComponent } from './components/personal/personal.component';

@NgModule({
  declarations: [
    AppComponent,
    StockComponent,
    LoginComponent,
    CardComponent,
    TableComponent,
    TablesComponent,
    OrderComponent,
    RegisterComponent,
    AdministradorComponent,
    PersonalComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    routing
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
