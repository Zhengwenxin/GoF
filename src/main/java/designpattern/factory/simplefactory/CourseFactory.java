package designpattern.factory.simplefactory;

/**
 * 简单工厂
 */
public class CourseFactory {
    /**
     * 第一个版本的工厂
     * @param name
     * @return
     */
    public ICourse createV1(String name){
        if ("Java".equals(name)){
            return new JavaCourse();
        } else if ("Python".equals(name)){
            return new PythonCourse();
        } else{
            return null;
        }
    }

    /**
     * 第二个版本的工厂
     * @param className
     * @version V2版本解决了V1 每次新增其他课程所产生的的代码修改问题，采用反射技术，符合开闭原则。
     * @return
     */
    public ICourse createV2(String className){
      try{
          if (!(null ==className)|| "".equals(className)){
              return (ICourse)Class.forName(className).newInstance();
          }
      } catch (Exception e){
          e.printStackTrace();
      }
      return  null;
    }

    /**
     * 第三个版本的工厂
     * @param clazz
     * @version V3版本解决了V2 方法参数是字符串的问题，提升了可控性，不需要强制转型。
     * @return
     */
    public ICourse createV3(Class<? extends ICourse> clazz){
        try{
            if (!(null == clazz)) {
                return clazz.newInstance();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
