/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tupinamba.gerencial.persistence;

import e_exceptions.report.ExceptionReporter;
import e_persistence.services.DefaultService;
import e_persistence.services.exceptions.ServiceException;
import e_persistence.session.Session;
import e_persistence.session.exceptions.BeginException;
import e_persistence.session.exceptions.CommitException;
import e_persistence.session.exceptions.RollbackException;

/**
 *
 * @author Pablo JS dos Santos
 */
public abstract class GerencialServerService<T, E> extends DefaultService<T, E>
{
    public GerencialServerService(Class clazz, Session session)
    {
        super(clazz, session);
    }

    public void begin() throws ServiceException
    {
        try
        {
            this.getSession().begin();
        } catch (BeginException ex)
        {
            throw new ServiceException("Falha ao abrir uma nova transação no banco de dados", ex);
        }
    }

    public void commit() throws ServiceException
    {
        try
        {
            this.getSession().commit();
        } catch (CommitException ex)
        {
            throw new ServiceException("Falha ao concluír a transação no banco de dados", ex);
        }
    }

    public void rollback(Throwable exception) throws ServiceException
    {
        try
        {
            this.getSession().rollback();
        } catch (RollbackException ex)
        {
            ExceptionReporter.reportException(ex);
        }

        throw new ServiceException("Falha ao concluír a transação no banco de dados", exception);
    }

    public String trimQuery(StringBuilder builder)
    {
        if (builder.toString().endsWith(" WHERE "))
        {
            builder.delete(builder.length() - " WHERE ".length(), builder.length());
        }else if(builder.toString().endsWith(" AND "))
        {
            builder.delete(builder.length() - " AND ".length(), builder.length());
        }

        return builder.toString();
    }
}

