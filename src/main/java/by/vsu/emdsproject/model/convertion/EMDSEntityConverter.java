package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.AbstractEntity;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Max
 *         Date: 18.05.13
 *         Time: 2:39
 */
public abstract class EMDSEntityConverter<T extends AbstractEntity> implements Converter<String, T> {

    // todo  scan by ClassPathScanningCandidateComponentProvider for converters?

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> clazz;

    public EMDSEntityConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convert(String id) {

        if (id != null) {
            try {
                return entityManager.find(clazz, Long.parseLong(id));
            } catch (NumberFormatException e) {
            }
        }

        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }

    }

}
