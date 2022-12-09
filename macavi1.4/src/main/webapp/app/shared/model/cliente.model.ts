import { IFactura } from 'app/shared/model/factura.model';
import { ICiudad } from 'app/shared/model/ciudad.model';
import { ITipoDni } from 'app/shared/model/tipo-dni.model';

export interface ICliente {
  id?: number;
  razonSocial?: string;
  direccion?: string;
  telefono?: number;
  facturas?: IFactura[] | null;
  locate?: ICiudad;
  tipoDni?: ITipoDni;
}

export const defaultValue: Readonly<ICliente> = {};
