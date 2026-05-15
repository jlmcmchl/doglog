package dev.doglog.internal.writers;

import dev.doglog.DogLogOptions;
import org.jspecify.annotations.Nullable;
import org.wpilib.hardware.power.PowerDistribution;
import org.wpilib.util.struct.StructSerializable;

/** Consumes log entries provided by DogLog. Implementations decide how to process the log data. */
public interface LogWriterHighLevel extends LogWriterBase, AutoCloseable {
  public static LogWriterHighLevel create(DogLogOptions options) {
    return new LogWriter(options);
  }

  public void setPdh(@Nullable PowerDistribution pdh);

  public void setOptions(DogLogOptions newOptions);

  public void log(long timestamp, String key, int[] value);

  public <T extends StructSerializable> void log(long timestamp, String key, T[] value);

  public <T extends StructSerializable> void log(long timestamp, String key, T value);
}
