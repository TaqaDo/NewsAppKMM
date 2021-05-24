//
//  Extension.swift
//  iosApp
//
//  Created by talgar osmonov on 24/5/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import UIKit
import SnapKit

extension UITableViewCell {
    static var cellID: String {
        return className
    }
}

extension UICollectionViewCell {
    static var cellID: String {
        return className
    }
}

extension NSObject {
    var className: String {
        return type(of: self).className
    }
    
    static var className: String {
        return String(describing: self)
    }
}

extension UIView {
    
    var safeArea: ConstraintBasicAttributesDSL {
        if #available(iOS 11.0, *) {
            return self.safeAreaLayoutGuide.snp
        } else {
            return self.snp
        }
    }
    
    var safeAreaEdgesInset: UIEdgeInsets {
        if #available(iOS 11.0, *) {
            return self.safeAreaInsets
        } else {
            return UIEdgeInsets()
        }
    }
}
