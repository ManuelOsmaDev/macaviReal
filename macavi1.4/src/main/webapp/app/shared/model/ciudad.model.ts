import { ICliente } from 'app/shared/model/cliente.model';
import { IDepartamento } from 'app/shared/model/departamento.model';

export interface ICiudad {
  id?: number;
  nombreCiudad?: string;
  clientes?: ICliente[] | null;
  departamento?: IDepartamento;
}

export const defaultValue: Readonly<ICiudad> = {};
