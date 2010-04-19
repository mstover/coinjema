To use Coinjema in your project:
1. Include the coinjema-core.jar file in your project's classpath.
2. Download AspectJ 1.5 (or higher) and copy the aspectjrt.jar to your project's classpath.
   Copy the aspectjtools.jar to your Ant's home /lib directory.  
3. If you don't use Ant to compile your project, you can compile using AspectJ's compiler, but
   you are on your own to figure that out.
4. Also download Groovy and include the embeddable jar in your project's classpath.
5. when compiling your project with AspectJ's compiler, include the coinjema-core.jar in the 
   "aspect path".
6. See the tiny sample app (in directory /sampleProject) for an example of an Ant build file
   that does this.
7. Annotate your classes that you want to receive automatic dependency-injection with the 
   @CoinjemaObject annotation.
8. Annotate these classes' dependency injection methods with @CoinjemaDependency.
9. Optional: add constructor(s) to your class that take a CoinjemaContext object as the last 
    parameter.  No implementation is required for Coinjema's purposes.
10. See the sample app for an example, as well as all the test cases (available in coinjema's CVS repository).

==========================================================================

Coinjema version 1.0 is the first product release of Coinjema.

==========================================================================

Coinjema version 0.6 is the first Beta release of Coinjema.

===========================================================================

Coinjema version 0.4 is a fully working release, though still not production-ready.

===========================================================================

Coinjema version 0.3 is the first alpha release for Coinjema.  It is not yet intended to be
considered production-ready, but there shouldn't be drastic changes in how Coinjema works going
forward. This release may be of some interest to users who wish to experiment or wish to explore
alternative Dependency Injection techniques.  Also, any feedback from those who play around
with Coinjema is highly welcome.