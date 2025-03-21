package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignClient.IClientesFeign;
import com.mx.Tienda.FeignClient.IProductosFeign;
import com.mx.Tienda.FeignClient.IProveedoresFeign;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Repository.ITiendaRepository;

@Service

@SuppressWarnings("unchecked")
public class TiendaServiceImpl implements ITiendaService {
	// I N Y E C C I O N D E P E N D E N C I A S
	@Autowired
	private ITiendaRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IClientesFeign clientesFC;

	@Autowired
	private IProductosFeign productosFC;

	@Autowired
	private IProveedoresFeign proveedoresFC;

	// -----SERVICOS DE GESTION TIENDA
	@Override
	public void guardar(Tienda tienda) {
		repository.save(tienda);
	}

	@Override
	public void editar(Tienda tienda) {
		repository.save(tienda);

	}

	@Override
	public void eliminar(int idTienda) {
		repository.deleteById(idTienda);

	}

	@Override
	public Tienda buscar(int idTienda) {
		return repository.findById(idTienda).orElse(null);
	}

	@Override
	public List<Tienda> listar() {
		// TODO Auto-generated method stub
		return (List<Tienda>) repository.findAll();
	}

	// -------SERVICOS DE CLIENTES

	// metodos con FeignClient
	public Clientes saveClientes(Clientes cliente) {
		return clientesFC.save(cliente);

	}

	public List<Clientes> getClientes(int idTienda) {
		return clientesFC.getClientesByTiendaId(idTienda);
	}

	// metodo con restTemplate

	public Clientes saveClientesRT(Clientes cliente) {
		ResponseEntity<Clientes> response = restTemplate.postForEntity("http://localhost:8013/Clientes", cliente,
				Clientes.class);
		return response.getBody();

	}

	public List<Clientes> getClientesRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8013/Clientes/tienda/" + tiendaId, null, List.class);

	}

	// -------SERVICOS DE PRODUCTOS

	public Productos saveProductos(Productos producto) {
		return productosFC.saveProducto(producto);
	}

	public List<Productos> getProductos(int tiendaId) {
		return productosFC.getProductosByTiendaId(tiendaId);
	}

	// metodo con restTemplate

	public Productos saveProductosRT(Productos producto) {
		ResponseEntity<Productos> response = restTemplate.postForEntity("http://localhost:8010/Productos", producto,
				Productos.class);
		return response.getBody();

	}

	public List<Productos> getProductosRT(int tiendaId) {

		return restTemplate.getForObject("http://localhost:8010/Productos/buscarTienda/" + tiendaId, List.class);
		// return
		// restTemplate.postForObject("http://localhost:8010/Productos/buscarTienda" +
		// tiendaId, null, List.class);
	}

	// -------SERVICOS DE provedores

	public Proveedores saveProveedores(Proveedores proveedor) {
		return proveedoresFC.saveProveedores(proveedor);
	}

	public List<Proveedores> getProveedores(int tiendaId) {
		return proveedoresFC.getProveedoresBytiendaId(tiendaId);
	}

	// metodo con restTemplate

	public Proveedores saveProveedoresRT(Proveedores proveedor) {
		ResponseEntity<Proveedores> response = restTemplate.postForEntity("http://localhost:8011/Proveedores",
				proveedor, Proveedores.class);
		return response.getBody();

	}

	public List<Proveedores> getProveedoresRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8011/Proveedores/buscarTienda/" + tiendaId, null,
				List.class);

	}

	// ------------------------------------------------------------------------------------
	// relacion de la tienda y sus modulos
	// ------------------------------------------------------------------------------------

	public Map<String, Object> obtenerTodosLosModulos(int tiendaId) {

		Map<String, Object> resultado = new HashMap<>();

		// consultar y validar la tienda
		Tienda tienda = this.buscar(tiendaId);
		if (tienda == null) {
			resultado.put("Mensaje", "La tienda con ID: " + tiendaId + " no existe");
			return resultado;
		}
		resultado.put("Tienda", tienda);

		// validarclientes
		List<Clientes> clientes = this.getClientes(tiendaId);
		if (clientes == null || clientes.isEmpty()) {
			resultado.put("Clientes", "La tienda no tiene clientes");
		} else {
			resultado.put("Clientes", clientes);
		}
		// vlaidar los productos
		List<Productos> productos = this.getProductos(tiendaId);
		if (productos == null || productos.isEmpty()) {
			resultado.put("Productos", "La tienda no tiene productos");
		} else {
			resultado.put("Productos", productos);
		}

		// vlaidar los provedores
		List<Proveedores> proveedores = this.getProveedores(tiendaId);
		if (proveedores == null || proveedores.isEmpty()) {
			resultado.put("Proveedores", "La tienda no tiene proveedores");
		} else {
			resultado.put("Proveedores", proveedores);
		}

		return resultado;
	}

}
