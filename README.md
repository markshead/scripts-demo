This is a simple demonstration of how you can use two scripting languages to interact with Java objects. This can be useful
when you need to setup an application that can have code added at run time. For example, I've used MVEL to create discount
rules for an ecommerce system that needed quite a bit flexibility that couldn't be determined up front.

The interesting parts are in the AccountServiceTest. None of this code is should be expected to high performance or ready
for production. It is just two simple examples of what can be done with scripting inside of Java.