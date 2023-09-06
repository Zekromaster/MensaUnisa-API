package net.zekromaster.mensaunisa.api.serialization.validators;

public interface ValidatorRegisterer {

    ValidatorRegisterer DEFAULT = new DefaultValidatorRegisterer();

    void registerValidators();

}
