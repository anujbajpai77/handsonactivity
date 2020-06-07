/*
 * package com.ibm.activity.ordersservice.client;
 * 
 * @Component public class FeignClientInterceptor implements RequestInterceptor
 * {
 * 
 * private static final String AUTHORIZATION_HEADER="Authorization"; private
 * static final String TOKEN_TYPE = "Bearer";
 * 
 * @Override public void apply(RequestTemplate requestTemplate) { Authentication
 * authentication = SecurityContextHolder.getContext().getAuthentication();
 * 
 * if (authentication != null && authentication.getDetails() instanceof
 * OAuth2AuthenticationDetails) { OAuth2AuthenticationDetails details =
 * (OAuth2AuthenticationDetails) authentication.getDetails();
 * requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s",
 * TOKEN_TYPE, details.getTokenValue())); } } }
 */