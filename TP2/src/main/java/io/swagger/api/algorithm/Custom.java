package io.swagger.api.algorithm;

import io.swagger.api.AlgorithmService;
import io.swagger.api.annotations.GroupedApiResponsesOk;
import io.swagger.api.factories.AlgorithmFactory;
import io.swagger.v3.oas.annotations.Operation;

import javax.servlet.ServletConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/custom")

public class Custom {
    private final AlgorithmService delegate;

    public Custom(@Context ServletConfig servletContext) {
        AlgorithmService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("Algorithm.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (AlgorithmService) Class.forName(implClass).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = AlgorithmFactory.getAlgorithm();
        }
        this.delegate = delegate;
    }

    @GET
    @Path("/custom")
    @Produces({MediaType.TEXT_PLAIN})
    @Operation(summary = "Custom algorithm with CPU and RAM usage", description = "Custom algorithm whose sole purpose is to waste CPU and RAM by generating a list of 10.000 items in reversed order and sorting them. Returns the sorted list.")
    @GroupedApiResponsesOk
    public Response customAlgorithmPlainGet() throws io.swagger.api.NotFoundException, IOException {
        List<Integer> list = new ArrayList<>();
        int maxItems = 10000;

        for (int i = 0; i < maxItems; i++) {
            list.add(maxItems - i);
        }

        Collections.sort(list);

        return Response.ok(list.toString()).build();
    }
}
