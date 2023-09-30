package org.coinjema.context;

 class CoinjemaClassInfo {

     final Class<?> clzz;
      final String simpleName;

     public CoinjemaClassInfo(Class<?> clzz) {
         this.clzz = clzz;
         this.simpleName = getSimpleName(clzz);

     }

     private  String getSimpleName(final Class<?> clazz) {
         CoinjemaObject ann = findObjectAnnotation(clazz);
         if (ann != null && ann.type().length() > 0)
             return ann.type();
         else
             return clazz.getSimpleName();
     }

     private  CoinjemaObject findObjectAnnotation(Class<?> clazz) {
         Class parent = clazz;
         CoinjemaObject ann = null;
         while (ann == null && parent != Object.class) {
             ann = (CoinjemaObject) parent.getAnnotation(CoinjemaObject.class);
             if (ann == null)
                 parent = parent.getSuperclass();
         }
         return ann;
     }
 }
