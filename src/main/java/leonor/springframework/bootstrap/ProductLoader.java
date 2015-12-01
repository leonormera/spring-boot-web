package leonor.springframework.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import leonor.springframework.domain.Product;
import leonor.springframework.repositories.ProductRepository;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Camisa Polo");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setCategoria("CAMISAS");
        shirt.setProductId("12345678");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Zapatos Adidas");
        mug.setCategoria("ZAPATOS DE MUJER");
        mug.setProductId("98765432");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Dato grabado - id:" + mug.getId());
    }
}
