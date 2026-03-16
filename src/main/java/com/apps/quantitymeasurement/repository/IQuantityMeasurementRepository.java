package com.apps.quantitymeasurement.repository;

import java.util.List;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
;

public interface IQuantityMeasurementRepository {

    void saveMeasurement(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();

}