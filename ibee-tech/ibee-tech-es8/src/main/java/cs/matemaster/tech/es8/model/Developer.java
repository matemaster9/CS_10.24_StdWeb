package cs.matemaster.tech.es8.model;

import java.util.function.Function;

/**
 * @author matemaster
 */
public class Developer<E> {

    private String name;

    private Integer age;

    private String job;

    private E project;

    private Developer(Builder<E> builder) {
        name = builder.name;
        age = builder.age;
        job = builder.job;
        project = builder.project;
    }

    public static <E> Developer<E> of(Function<Builder<E>, ObjectBuilder<Developer<E>>> func) {
        return func.apply(new Builder<>()).build();
    }

    public static class Builder<E> implements ObjectBuilder<Developer<E>> {

        private String name;

        private Integer age;

        private String job;

        private E project;

        public Builder() {
        }

        public final Builder<E> name(String name) {
            this.name = name;
            return this;
        }

        public final Builder<E> age(Integer age) {
            this.age = age;
            return this;
        }

        public final Builder<E> job(String job) {
            this.job = job;
            return this;
        }

        public final Builder<E> project(E project) {
            this.project = project;
            return this;
        }

        @Override
        public Developer<E> build() {
            return new Developer<>(this);
        }
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", project=" + project +
                '}';
    }
}
