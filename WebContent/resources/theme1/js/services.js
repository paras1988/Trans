'use strict';

/* Services */

/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

 */

var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('DummyFactory', function ($resource) {
    return $resource('/Sample2/users', {}, {
        query: { method: 'GET'}
    });
});


services.factory('UsersFactory', function ($resource) {
    return $resource('/Sample2/users', {}, {
        query: { method: 'GET' , isArray: true},
        create: { method: 'POST' }
    });
});

services.factory('UserFactory', function ($resource) {
    return $resource('/Sample2/users/:id', {}, {
        show: { method: 'GET' },
        delete1: { method: 'DELETE', params: {id: '@id'} },
        update: { method: 'PUT', params: {id: '@id'} }
    });
});
