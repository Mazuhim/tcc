package tupinamba.gerencial.webservice;

import com.google.gson.Gson;
import e_exceptions.AuthenticationException;
import e_exceptions.DefaultException;
import e_exceptions.IssueException;
import e_tools.text.Strings;
import java.io.InputStream;
import javax.ws.rs.core.Response;
import tupinamba.gerencial.utils.GsonFactory;

public class StandardActionProvider {

    public Response createResponse(int status) {
        return this.createResponse(status, null);
    }

    public Response createResponse(int status, Object message) {
        if (message == null) {
            return Response.status(status).build();
        }
        Object responseContent;

        if (message instanceof String || message instanceof Byte[] || message instanceof InputStream) {
            responseContent = message;
        } else {
            Gson gson = GsonFactory.createGson();
            responseContent = gson.toJson(message);
        }

        return Response.status(status).entity(responseContent).build();
    }

    public Response createErrorResponse(Throwable e) {
        if (!(e instanceof AuthenticationException)) {
            Strings.printStackTrace(e);
        }
        StringBuilder builder = new StringBuilder("{\"message\":\"");

        if (e instanceof IssueException) {
            IssueException issueThrowble = (IssueException) e;
            builder.append(issueThrowble.toString()).append("\",\"\nstackTrace\":\"");
            builder.append(issueThrowble.getStackTraceString());
        } else if (e instanceof DefaultException) {
            DefaultException defaultThrowble = (DefaultException) e;
            builder.append(defaultThrowble.getMessage()).append("\",\"\nstackTrace\":\"");
            builder.append(defaultThrowble.getStackTraceString());
        } else {
            builder.append("erro inesperado...").append("\",\"\nstackTrace\":\"");
            builder.append(Strings.toStackTrace(e));
        }
        builder.append("\"}");

        return Response.status(500).entity(builder.toString()).build();
    }

    public <T> T parseParam(Class<T> type, String json) {
        if (type == String.class) {
            return (T) json;
        }

        Gson gson = GsonFactory.createGson();
        return gson.fromJson(json, type);
    }
}
