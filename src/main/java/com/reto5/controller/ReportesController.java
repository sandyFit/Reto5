package com.reto5.controller;

import java.sql.SQLException;
import java.util.List;

import com.reto5.model.dao.*;
import com.reto5.model.vo.*;

public class ReportesController {
    private PrimerInformeDao primerInformeDao;
    private SegundoInformeDao segundoInformeDao;
    private TercerInformeDao tercerInformeDao;

    public ReportesController() {
        primerInformeDao = new PrimerInformeDao();
        segundoInformeDao = new SegundoInformeDao();
        tercerInformeDao = new TercerInformeDao();

    }

    public List<PrimerInformeVo> listarLideresCompras() throws SQLException {
        return primerInformeDao.listar();
    }

    public List<SegundoInformeVo> listarProyectosPorCiudades() throws SQLException {
        return segundoInformeDao.listar();
    }

    public List<TercerInformeVo> listarProyectosPorProveedor() throws SQLException {
        return tercerInformeDao.listar();
    }
    
}
