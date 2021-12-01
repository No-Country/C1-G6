import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { CardComponent } from "./components/card/card.component";
import { LoginComponent } from "./components/login/login.component";
import { OrderComponent } from "./components/order/order.component";
import { RegisterComponent } from "./components/register/register.component";
import { StockComponent } from "./components/stock/stock.component";
import { TableComponent } from "./components/table/table.component";
import { TablesComponent } from "./components/tables/tables.component";
import { AdministradorComponent } from "./components/administrador/administrador.component";
import { PersonalComponent } from "./components/personal/personal.component";


const appRoutes: Routes = [
    {   path: '', component: CardComponent},
    {   path: 'Card', component: CardComponent },
    {   path: 'Login', component: LoginComponent },
    {   path: 'Order', component: OrderComponent},
    {   path: 'Register', component: RegisterComponent},
    {   path: 'Stock', component: StockComponent},
    {   path: 'Table', component: TableComponent},
    {   path: 'Tables', component: TablesComponent},
    {   path: 'Administrador', component: AdministradorComponent},
    {   path: 'Personal', component:PersonalComponent},
    
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(appRoutes);
