/**
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.dns.internal.http;

import com.oracle.bmc.dns.model.*;
import com.oracle.bmc.dns.requests.*;
import com.oracle.bmc.dns.responses.*;
import org.apache.commons.lang3.Validate;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20180115")
@lombok.extern.slf4j.Slf4j
public class GetRRSetConverter {
    private static final com.oracle.bmc.http.internal.ResponseConversionFunctionFactory
            RESPONSE_CONVERSION_FACTORY =
                    new com.oracle.bmc.http.internal.ResponseConversionFunctionFactory();

    public static GetRRSetRequest interceptRequest(GetRRSetRequest request) {

        return request;
    }

    public static com.oracle.bmc.http.internal.WrappedInvocationBuilder fromRequest(
            com.oracle.bmc.http.internal.RestClient client, GetRRSetRequest request) {
        Validate.notNull(request, "request instance is required");
        Validate.notBlank(request.getZoneNameOrId(), "zoneNameOrId must not be blank");
        Validate.notBlank(request.getDomain(), "domain must not be blank");
        Validate.notBlank(request.getRtype(), "rtype must not be blank");

        com.oracle.bmc.http.internal.WrappedWebTarget target =
                client.getBaseTarget()
                        .path("/20180115")
                        .path("zones")
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request.getZoneNameOrId()))
                        .path("records")
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request.getDomain()))
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request.getRtype()));

        if (request.getLimit() != null) {
            target =
                    target.queryParam(
                            "limit",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getLimit()));
        }

        if (request.getPage() != null) {
            target =
                    target.queryParam(
                            "page",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getPage()));
        }

        if (request.getZoneVersion() != null) {
            target =
                    target.queryParam(
                            "zoneVersion",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getZoneVersion()));
        }

        if (request.getCompartmentId() != null) {
            target =
                    target.queryParam(
                            "compartmentId",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getCompartmentId()));
        }

        com.oracle.bmc.http.internal.WrappedInvocationBuilder ib = target.request();

        ib.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);

        if (request.getIfNoneMatch() != null) {
            ib.header("If-None-Match", request.getIfNoneMatch());
        }

        if (request.getIfModifiedSince() != null) {
            ib.header("If-Modified-Since", request.getIfModifiedSince());
        }

        return ib;
    }

    public static com.google.common.base.Function<javax.ws.rs.core.Response, GetRRSetResponse>
            fromResponse() {
        final com.google.common.base.Function<javax.ws.rs.core.Response, GetRRSetResponse>
                transformer =
                        new com.google.common.base.Function<
                                javax.ws.rs.core.Response, GetRRSetResponse>() {
                            @Override
                            public GetRRSetResponse apply(javax.ws.rs.core.Response rawResponse) {
                                LOG.trace("Transform function invoked for GetRRSetResponse");
                                com.google.common.base.Function<
                                                javax.ws.rs.core.Response,
                                                com.oracle.bmc.http.internal.WithHeaders<RRSet>>
                                        responseFn =
                                                RESPONSE_CONVERSION_FACTORY.create(RRSet.class);

                                com.oracle.bmc.http.internal.WithHeaders<RRSet> response =
                                        responseFn.apply(rawResponse);
                                javax.ws.rs.core.MultivaluedMap<String, String> headers =
                                        response.getHeaders();

                                GetRRSetResponse.Builder builder = GetRRSetResponse.builder();

                                builder.rRSet(response.getItem());

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcNextPageHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-next-page");
                                if (opcNextPageHeader.isPresent()) {
                                    builder.opcNextPage(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-next-page",
                                                    opcNextPageHeader.get().get(0),
                                                    String.class));
                                }

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcTotalItemsHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-total-items");
                                if (opcTotalItemsHeader.isPresent()) {
                                    builder.opcTotalItems(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-total-items",
                                                    opcTotalItemsHeader.get().get(0),
                                                    Integer.class));
                                }

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcRequestIdHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-request-id");
                                if (opcRequestIdHeader.isPresent()) {
                                    builder.opcRequestId(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-request-id",
                                                    opcRequestIdHeader.get().get(0),
                                                    String.class));
                                }

                                com.google.common.base.Optional<java.util.List<String>> eTagHeader =
                                        com.oracle.bmc.http.internal.HeaderUtils.get(
                                                headers, "eTag");
                                if (eTagHeader.isPresent()) {
                                    builder.eTag(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "eTag", eTagHeader.get().get(0), String.class));
                                }

                                GetRRSetResponse responseWrapper = builder.build();

                                return responseWrapper;
                            }
                        };
        return transformer;
    }
}
