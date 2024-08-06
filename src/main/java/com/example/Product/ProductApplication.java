package com.example.Product;

import com.example.Product.product.Product;
import com.example.Product.productManagerImpl.ProductManagerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
		ProductManagerImpl manager = new ProductManagerImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Select:");
			System.out.println("1. add product:");
			System.out.println("2. get product:");
			System.out.println("3. update product:");
			System.out.println("4. remove product:");
			System.out.println("5. view all product");
			System.out.println("6. exit ");

			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("id:");
					int id = scanner.nextInt();
					scanner.nextLine();

					System.out.println("name:");
					String name = scanner.nextLine();

					System.out.println("price:");
					double price = scanner.nextDouble();
					scanner.nextLine();

					System.out.println("quantity:");
					int quantity = scanner.nextInt();
					scanner.nextLine();

					manager.addProduct(new Product(id, name, price, quantity));
					break;

				case 2:
					System.out.println("id:");
					id = scanner.nextInt();
					Product product = manager.getProduct(id);
					if (product != null) {
						System.out.println("name: " + product.getName());
						System.out.println("price: " + product.getPrice());
						System.out.println("quantity: " + product.getQuantity());
					} else {
						System.out.println("no player found with this ID.");
					}
					break;
				case 3:
					System.out.println("id:");
					id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("new name:");
					name = scanner.nextLine();
					System.out.println("new price:");
					price = scanner.nextInt();
					scanner.nextLine();
					System.out.println("new quantity:");
					quantity = Integer.parseInt(scanner.nextLine());  // بعدا خونده بشه که چطور کار میکنه
					manager.updateProduct(id, new Product(id, name, price, quantity));
					break;
				case 4:
					System.out.println("id:");
					id = scanner.nextInt();
					manager.deleteProduct(id);
					break;
				case 5:
					for (Product p : manager.getAllProducts()) {
						System.out.println("id: " + p.getId() + ", name: " + p.getName() + ", price: " + p.getPrice() + ", quantity: " + p.getQuantity());
					}
					break;
				case 6:
					System.out.println("exit");
					return;
				default:
					System.out.println("invalid selection.");
			}
			}
		}
	}
