package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.model.BaseModel;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
	protected abstract JpaRepository<T, Long> getRepository();

	@Override
	public T create(final T item) {
		logger.trace("Creating {}.", item);
		return getRepository().save(item);
	}

	@SafeVarargs
	@Override
	public final List<T> createAll(final T... items) {
		return createAll(Arrays.asList(items));
	}

	@Override
	public List<T> createAll(final List<T> items) {
		return getRepository().saveAll(items);
	}

	@Override
	public void update(final T item) {
		logger.trace("Updating {}.", item);
		getRepository().save(item);
	}

	@Override
	public void delete(final T item) {
		getRepository().delete(item);
	}

	@Override
	public void deleteById(final Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public T get(final Long id) {
		T item = getRepository().findById(id).orElseThrow();
		logger.trace("Item found matching id:{}.", id);
		return item;
	}

	@Override
	public boolean exists(final T item) {
		logger.trace("Checking whether {} exists.", item);
		return getRepository().existsById(item.getId());
	}

	@Override
	public List<T> findAll() {
		logger.trace("Retrieving all items.");
		return getRepository().findAll();
	}

	@Override
	public Long count() {
		return getRepository().count();
	}
}
