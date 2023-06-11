package by.radevich.helloservlet;

import lombok.*;
@Data//добавляет все сразу
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
    private int age;
    private  String name;
    private String login;
    private String password;
}
