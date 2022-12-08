import React from 'react';
import { Switch } from 'react-router-dom';
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Producto from './producto';
import Factura from './factura';
import Cliente from './cliente';
import Pais from './pais';
import Ciudad from './ciudad';
import Departamento from './departamento';
import TipoDni from './tipo-dni';
import ProdFact from './prod-fact';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default ({ match }) => {
  return (
    <div>
      <Switch>
        {/* prettier-ignore */}
        <ErrorBoundaryRoute path={`${match.url}producto`} component={Producto} />
        <ErrorBoundaryRoute path={`${match.url}factura`} component={Factura} />
        <ErrorBoundaryRoute path={`${match.url}cliente`} component={Cliente} />
        <ErrorBoundaryRoute path={`${match.url}pais`} component={Pais} />
        <ErrorBoundaryRoute path={`${match.url}ciudad`} component={Ciudad} />
        <ErrorBoundaryRoute path={`${match.url}departamento`} component={Departamento} />
        <ErrorBoundaryRoute path={`${match.url}tipo-dni`} component={TipoDni} />
        <ErrorBoundaryRoute path={`${match.url}prod-fact`} component={ProdFact} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </Switch>
    </div>
  );
};
