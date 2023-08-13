package com.serviceplazoleta.infrastructure.configuration;


import com.serviceplazoleta.domain.api.ICategoryServicePort;
import com.serviceplazoleta.domain.api.IDishServicePort;
import com.serviceplazoleta.domain.api.IRestaurantServicePort;
import com.serviceplazoleta.domain.spi.ICategoryPersistencePort;
import com.serviceplazoleta.domain.spi.IDishPersistencePort;
import com.serviceplazoleta.domain.spi.IRestaurantPersistencePort;
import com.serviceplazoleta.domain.spi.feignclient.IUserFeignClientPort;
import com.serviceplazoleta.domain.useCase.CategoryUseCase;
import com.serviceplazoleta.domain.useCase.DishUseCase;
import com.serviceplazoleta.domain.useCase.RestaurantUseCase;
import com.serviceplazoleta.infrastructure.out.feignclient.IUserFeignClient;
import com.serviceplazoleta.infrastructure.out.feignclient.adapter.UserFeignAdapter;
import com.serviceplazoleta.infrastructure.out.feignclient.mapper.IUserDtoMapper;
import com.serviceplazoleta.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.serviceplazoleta.infrastructure.out.jpa.adapter.DishJpaAdapter;
import com.serviceplazoleta.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.serviceplazoleta.infrastructure.out.jpa.repository.ICategoryRepository;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IDishRepository;
import com.serviceplazoleta.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IUserFeignClient userFeignClient;
    private final IUserDtoMapper userDtoMapper;


    public BeanConfiguration(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper restaurantEntityMapper, IDishRepository dishRepository, IDishEntityMapper dishEntityMapper, ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper, IUserFeignClient userFeignClient, IUserDtoMapper userDtoMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantEntityMapper = restaurantEntityMapper;
        this.dishRepository = dishRepository;
        this.dishEntityMapper = dishEntityMapper;
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
        this.userFeignClient = userFeignClient;
        this.userDtoMapper = userDtoMapper;

    }

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(){
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort(){
        return new RestaurantUseCase(restaurantPersistencePort(), userFeignClientPort());
    }
    @Bean
    public IDishPersistencePort dishPersistencePort(){
        return new DishJpaAdapter(dishRepository,dishEntityMapper);
    }
    @Bean    public IDishServicePort dishServicePort(){
        return new DishUseCase(dishPersistencePort(),userFeignClientPort(),restaurantPersistencePort());
    }
    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository,categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }
    @Bean
    public IUserFeignClientPort userFeignClientPort(){
        return new UserFeignAdapter(userFeignClient, userDtoMapper);
    }







}
