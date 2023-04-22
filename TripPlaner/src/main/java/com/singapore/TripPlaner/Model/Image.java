package com.singapore.TripPlaner.Model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Image extends PersistentAbstract {
    String url;
}
