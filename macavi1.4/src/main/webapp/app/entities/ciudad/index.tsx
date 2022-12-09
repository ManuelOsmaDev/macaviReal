import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Ciudad from './ciudad';
import CiudadDetail from './ciudad-detail';
import CiudadUpdate from './ciudad-update';
import CiudadDeleteDialog from './ciudad-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={CiudadUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={CiudadUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={CiudadDetail} />
      <ErrorBoundaryRoute path={match.url} component={Ciudad} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={CiudadDeleteDialog} />
  </>
);

export default Routes;
