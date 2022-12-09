import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Departamento from './departamento';
import DepartamentoDetail from './departamento-detail';
import DepartamentoUpdate from './departamento-update';
import DepartamentoDeleteDialog from './departamento-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={DepartamentoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={DepartamentoUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={DepartamentoDetail} />
      <ErrorBoundaryRoute path={match.url} component={Departamento} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={DepartamentoDeleteDialog} />
  </>
);

export default Routes;
