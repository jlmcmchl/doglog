package dev.doglog.internal.tunable.on_change;

import org.wpilib.util.function.FloatConsumer;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record FloatOnChange(FloatConsumer onChange, float defaultValue) {
  public void acceptDefault() {
    onChange.accept(defaultValue);
  }
}
