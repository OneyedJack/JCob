package jcob.bean.environment;

public class EnvironmentDivision
{
  private ConfigurationSection configurationSection;

  private InputOutputSection inputOutputSection;

  public EnvironmentDivision(ConfigurationSection configurationSection, InputOutputSection inputOutputSection)
  {
    super();
    this.configurationSection = configurationSection;
    this.inputOutputSection = inputOutputSection;
  }

  ConfigurationSection getConfigurationSection()
  {
    return configurationSection;
  }

  void setConfigurationSection(ConfigurationSection configurationSection)
  {
    this.configurationSection = configurationSection;
  }

  InputOutputSection getInputOutputSection()
  {
    return inputOutputSection;
  }

  void setInputOutputSection(InputOutputSection inputOutputSection)
  {
    this.inputOutputSection = inputOutputSection;
  }
}
