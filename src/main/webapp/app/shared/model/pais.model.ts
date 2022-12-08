import { IDepartamento } from 'app/shared/model/departamento.model';

export interface IPais {
  id?: number;
  nombrePais?: string;
  departamentos?: IDepartamento[] | null;
}

export const defaultValue: Readonly<IPais> = {};
