import { ICiudad } from 'app/shared/model/ciudad.model';
import { IPais } from 'app/shared/model/pais.model';

export interface IDepartamento {
  id?: number;
  nombreDepartamento?: string;
  ciudads?: ICiudad[] | null;
  pais?: IPais;
}

export const defaultValue: Readonly<IDepartamento> = {};
