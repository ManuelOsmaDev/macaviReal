import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './ciudad.reducer';

export const CiudadDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const ciudadEntity = useAppSelector(state => state.ciudad.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="ciudadDetailsHeading">
          <Translate contentKey="macaviApp.ciudad.detail.title">Ciudad</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{ciudadEntity.id}</dd>
          <dt>
            <span id="nombreCiudad">
              <Translate contentKey="macaviApp.ciudad.nombreCiudad">Nombre Ciudad</Translate>
            </span>
          </dt>
          <dd>{ciudadEntity.nombreCiudad}</dd>
          <dt>
            <Translate contentKey="macaviApp.ciudad.departamento">Departamento</Translate>
          </dt>
          <dd>{ciudadEntity.departamento ? ciudadEntity.departamento.nombreDepartamento : ''}</dd>
        </dl>
        <Button tag={Link} to="/ciudad" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/ciudad/${ciudadEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CiudadDetail;
