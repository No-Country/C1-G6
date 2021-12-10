import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { CardComponent } from "./components/card/card.component";
import { LoginComponent } from "./components/login/login.component";
import { OrderComponent } from "./components/order/order.component";
import { RegisterComponent } from "./components/register/register.component";
import { StockComponent } from "./components/stock/stock.component";
import { TablesComponent } from "./components/tables/tables.component";
import { AdministradorComponent } from "./components/administrador/administrador.component";
import { PersonalComponent } from "./components/personal/personal.component";
import { OrdersComponent } from "./components/orders/orders.component";
import { AddFoodComponent } from "./components/add-food/add-food.component";
import { AuthGuard } from "./auth.guard";

const appRoutes: Routes = [
    {   path: '', component: CardComponent},
    {   path: 'Card', component: CardComponent },
    {   path: 'Card/:id', component: CardComponent, canActivate: [AuthGuard]},
    {   path: 'Login', component: LoginComponent},
    {   path: 'Order/:id', component: OrderComponent, canActivate: [AuthGuard]},
    {   path: 'Order', component: OrderComponent, canActivate: [AuthGuard]},
    {   path: 'Orders', component: OrdersComponent, canActivate: [AuthGuard]},
    {   path: 'Register', component: RegisterComponent, canActivate: [AuthGuard]},
    {   path: 'Stock', component: StockComponent, canActivate: [AuthGuard]},
    {   path: 'Tables', component: TablesComponent, canActivate: [AuthGuard]},
    {   path: 'Administrador', component: AdministradorComponent},
    {   path: 'Personal', component:PersonalComponent, canActivate: [AuthGuard]},
    {   path: 'AddFood', component:AddFoodComponent, canActivate: [AuthGuard]},
    
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(appRoutes);
