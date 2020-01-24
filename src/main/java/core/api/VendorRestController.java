package core.api;

import core.model.Vendor;
import core.service.VendorService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Enable Cross-Origin Resource Sharing for GET request
// https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
@CrossOrigin

@RestController
@RequestMapping("/vendor")
public class VendorRestController {

  @Autowired
  VendorService vendorService;

  // Add product using POST parameters from Angular
  @PostMapping(path = "/add")
  public @ResponseBody String addNewProduct(@RequestBody Vendor vendor) {
    Vendor v = new Vendor();
    v.setVendorName(vendor.getVendorName());
    v.setVendorDescription(vendor.getVendorDescription());
    v.setVendorImageUrl(vendor.getVendorImageUrl());
    vendorService.addVendor(v);
    return "{\"message\":\"Added new Vendor\"}";
  }

  // Gets all vendor entities as JSON Array
  @GetMapping(path = "")
  public @ResponseBody Iterable<Vendor> getAllVendors() {
    return vendorService.getAllVendors();
  }

  // Gets vendor by id
  @GetMapping(path = "/{id}")
  public @ResponseBody Vendor getProduct(@PathVariable("id") Long id) {
    Optional<Vendor> vendorOptional = vendorService.getVendor(id);
    Vendor vendor;
    if (vendorOptional.isPresent()) {
      vendor = vendorOptional.get();

      // returns just the vendor for now...
      /**
       * We need all the products this vendor has as well. So either we send it here
       * ....or we make a seperate request and get it that way from angular
       */
      return vendor;
    } else
      return null;
  }
}
