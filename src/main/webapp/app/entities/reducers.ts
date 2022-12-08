import producto from 'app/entities/producto/producto.reducer';
import factura from 'app/entities/factura/factura.reducer';
import cliente from 'app/entities/cliente/cliente.reducer';
import pais from 'app/entities/pais/pais.reducer';
import ciudad from 'app/entities/ciudad/ciudad.reducer';
import departamento from 'app/entities/departamento/departamento.reducer';
import tipoDni from 'app/entities/tipo-dni/tipo-dni.reducer';
import prodFact from 'app/entities/prod-fact/prod-fact.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  producto,
  factura,
  cliente,
  pais,
  ciudad,
  departamento,
  tipoDni,
  prodFact,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
